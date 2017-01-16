
public class Libro {

    private String titulo;
    private String[] autores;
    private int fechaSalida;
    private String editor;
    private int numPaginas;

    public Libro(String titulo, String[] autores, int fechaSalida, String editor, int numPaginas) {
        this.titulo = titulo;
        this.autores = autores;
        this.fechaSalida = fechaSalida;
        this.editor = editor;
        this.numPaginas = numPaginas;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String[] getAutores() {
        return autores;
    }
    public void setAutores(String[] autores) {
        this.autores = autores;
    }
    public int getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void print(){
        System.out.println("Titulo : "+ titulo );
        for(int i = 0; i < autores.length; i++) {
            System.out.println("Autores : " + autores[i]);
        }
        System.out.println("Fecha de salida : " + fechaSalida);
        System.out.println("Editor : " + editor);
        System.out.println("Num paginas : " + numPaginas);
        System.out.println("---------------" +"\n");
    }

}
