public interface ProductoVisitor {
    void visitLaptop(Laptop laptop);
    void visitSmartphone(Smartphone smartphone);
    void visitAccessorio(Accesorio accesorio);
}
