package es.ulpgc.Calculator;

public class StringCalculator {

    public int calculate(String string) throws Exception {
        return "".equals(string) ? 0 : obtenerValor(string);

    }

    private Integer obtenerValor(String string) throws Exception {
        if(string.length()>1) return dividirString(string);
        return Integer.parseInt(string);
    }

    private Integer dividirString(String string) throws Exception {
        int res = 0;
        String[] numeros = string.split(",|\n");
        for (String num : numeros){
            if (buscarValorPeligroso(num)) continue;
            res += obtenerValor(num);
        }
        return res;
    }

    private boolean buscarValorPeligroso(String num) throws Exception {
        if(Integer.parseInt(num)<0)
            throw new Exception("Valor negativo");
        else if(Integer.parseInt(num)>1000)
            return true;
        return false;
    }
}
