public interface Visitor {
    void visit(Administrativo administrativo);
    void visit(Enfermero enfermero);
    void visit(Medico medico);
}
