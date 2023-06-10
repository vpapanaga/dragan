package md.papanaga.usm.tap.laborator4;

public class Camera {
    public enum CameraType {
        Viceu,
        Bucatarie,
        Living,
        Dormitor,
        Debara
    }

    double aria;
    CameraType cameraType;

    public Camera() {
    }

    public Camera(double aria, CameraType cameraType) {
        this.aria = aria;
        this.cameraType = cameraType;
    }

    public double getAria() {
        return aria;
    }

    public void setAria(double aria) {
        this.aria = aria;
    }

    public CameraType getCameraType() {
        return cameraType;
    }

    public void setCameraType(CameraType cameraType) {
        this.cameraType = cameraType;
    }

    @Override
    public String toString() {
        return "              Camera cu aria: "+aria;
    }
}
