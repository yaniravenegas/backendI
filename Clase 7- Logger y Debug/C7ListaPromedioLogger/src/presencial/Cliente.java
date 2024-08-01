package presencial;

public class Cliente {

    public static void main(String[] args) {
        App listado= new App();
        for (int i=0; i<10;i++){
            listado.agregarEnterosAlaLista(i);
        }
        //double avg = getAverage(listado);
    }

    private static double getAverage(List<Integer> listado) {
        return list.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }
}
