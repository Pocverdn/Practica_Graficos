package geometry;

import math.Vector4;
import math.UVN4x4;
import math.Matrix4x4;
import display.Scene;
import display.Colour;
import display.Material;

public class Triangle implements IntersectableObject {
    Vector4 v0, v1, v2; // Original vertices
    Vector4 tv0, tv1, tv2; // Transformed to camera coordinates
    int colorIndex;
    int materialIndex;

    public Triangle(Vector4 v0, Vector4 v1, Vector4 v2, int colorIndex, int materialIndex) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
        this.colorIndex = colorIndex;
        this.materialIndex = materialIndex;
    }

    @Override
    public Solution intersect(Ray ray) {
        Vector4 edge1 = Vector4.subtract(tv1, tv0);
        Vector4 edge2 = Vector4.subtract(tv2, tv0);
        Vector4 rayDir = ray.direction;
        Vector4 rayOrig = ray.origin;
        Vector4 org = Vector4.subtract(rayOrig, tv0);

        Vector4 v1 = Vector4.crossProduct(edge1, edge2);
        Vector4 v3 = Vector4.crossProduct(org, edge2);
        Vector4 v4 = Vector4.crossProduct(edge1, org);

        double D = -Vector4.dotProduct(rayDir, v1);
        if (Math.abs(D) < 1e-6) return null;

        double t = Vector4.dotProduct(org, v1) / D;
        double u = Vector4.dotProduct(rayDir, v3) / D;
        double v = -Vector4.dotProduct(rayDir, v4) / D;

        if (u >= 0 && v >= 0 && (u + v) <= 1 && t > 0.0001) {
            Vector4 point = ray.evaluate(t);
            Vector4 normal = Vector4.crossProduct(edge1, edge2);
            normal.normalize();
            Colour color = Scene.colors.get(colorIndex);
            Material mat = Scene.materials.get(materialIndex);
            return new Solution(point, normal, color, mat, t);
            
        } else {
            return null;
        }

        
    }

    @Override
    public void setCamera() {
        UVN4x4 uvn = Scene.camera.uvn;
        tv0 = Matrix4x4.times(uvn, v0);
        tv1 = Matrix4x4.times(uvn, v1);
        tv2 = Matrix4x4.times(uvn, v2);
    }

    public void reset() {
        tv0 = v0;
        tv1 = v1;
        tv2 = v2;
    }
}