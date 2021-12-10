abstract class Teacher {
    protected String _Nombre;
    protected int _Tipo;
    protected int _salarioBaseMensual =2000;
    protected int _comision = 500;
    protected int _bonus = 100;
    Teacher(String nombre) {
        _Nombre = nombre;
    }
    abstract int Sueldo();
}

class ProfesorTP extends Teacher {
    ProfesorTP(String nombre) {
        super(nombre);
    }

    int Sueldo() {
        return _salarioBaseMensual;
    }
}


class ProfesorTC extends Teacher {
    ProfesorTC(String nombre) {
        super(nombre);
    }
    int Sueldo() {
        return _salarioBaseMensual + _comision;
    }
}

class Administrativo extends Teacher {
    Administrativo(String nombre) {
        super(nombre);
    }
    int Sueldo() {
        return _salarioBaseMensual + _bonus;
    }
}