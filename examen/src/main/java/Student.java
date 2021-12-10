abstract class Student {
    protected String _Nombre;
    protected int _notaBase =11;

    Student(String nombre) {
        _Nombre = nombre;
    }

    abstract int Grado();
}

class Pregado extends Student {

    Pregado(String nombre) {
        super(nombre);
    }

    int Grado() {
        return _notaBase;
    }

}

class Maestria extends Student {

    Maestria(String nombre) {
        super(nombre);
    }

    int Grado() {
        return _notaBase + 1;
    }

}

class Doctorado extends Student {

    Doctorado(String nombre) {
        super(nombre);
    }

    int Grado() {
        return _notaBase + 2;
    }

}
