public interface Image {
    void display();
}

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk...." + fileName);
    }

    public void display() {
        System.out.println("Display image: " + fileName);
    }
}

public class ProxyImage implements Image {
    private RealImage image;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if(image == null) {
            image = new RealImage(fileName);
        }

        image.display();
    }
}
