package com.example.arthouseapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;
import android.transition.Scene;

import android.content.Context;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.SceneView;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

/**
 * This is an example activity that uses the Sceneform UX package to make common AR tasks easier.
 */

public class ArActivity extends AppCompatActivity {
    private static final String TAG = ArActivity.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;
    private ArFragment arFragment;
    private ModelRenderable andyRenderable;
    private ViewRenderable paintRenderable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkIsSupportedDeviceOrFinish(this)) {
            return;
        }
        Intent in = getIntent();
        Bundle b = in.getExtras();



        setContentView(R.layout.activity_ar);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.activity_ar);
        ViewRenderable.builder()
                .setView(this, R.layout.ar_image)
                .setVerticalAlignment(ViewRenderable.VerticalAlignment.CENTER)
                .setHorizontalAlignment(ViewRenderable.HorizontalAlignment.CENTER)
                .build()
                .thenAccept(renderable -> paintRenderable = renderable
                );
        arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    if (paintRenderable == null) {
                        return;
                    }

                    ImageView iv = paintRenderable.getView().findViewById(R.id.arImage);
                    iv.setImageResource(b.getInt("fileId"));
                    // Create the Anchor.
                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    TransformableNode painting = new TransformableNode(arFragment.getTransformationSystem());
                    painting.setParent(anchorNode);
                    painting.setRenderable(paintRenderable);
                    painting.getRotationController().setEnabled(false);
                    float[] yAxis = plane.getCenterPose().getYAxis();
                    Vector3 planeNormal = new Vector3(yAxis[0], yAxis[1], yAxis[2]);
                    Quaternion upQuat = Quaternion.lookRotation(planeNormal, Vector3.up());
                    painting.setWorldRotation(upQuat);
                    painting.select();
                });
    }


    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }
}
