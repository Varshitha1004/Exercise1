interface Compressor {
    void compress(String fileName);
}

class JPEGCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using JPEG.");
    }
}

class PNGCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("Compressing " + fileName + " using PNG.");
    }
}

class ImageStorage {
    private Compressor compressor;

    public ImageStorage(Compressor compressor) {
        this.compressor = compressor;
    }

    public void store(String fileName) {
        compressor.compress(fileName);
    }

    public void setCompressor(Compressor compressor) {
        this.compressor = compressor;
    }
}

// Main class to use ImageStorage
public class Mains {
    public static void main(String[] args) {
        Compressor jpegCompressor = new JPEGCompressor();
        Compressor pngCompressor = new PNGCompressor();

        ImageStorage imageStorage = new ImageStorage(jpegCompressor);
        imageStorage.store("photo1.jpg");

        imageStorage.setCompressor(pngCompressor);
        imageStorage.store("photo2.png");
    }
}
