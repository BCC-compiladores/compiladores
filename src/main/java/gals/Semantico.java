package gals;

import org.apache.commons.text.TextStringBuilder;
import utils.Operador;
import utils.Tipo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Semantico implements Constants
{

    ArrayDeque<Tipo> stack = new ArrayDeque<>();
    TextStringBuilder codigo = new TextStringBuilder();
    ArrayList<String> listaIdentificadores = new ArrayList<>();
    HashMap<String, Tipo> tabelaSimbolos = new HashMap<>();
    Tipo tipoVar = null;
    Operador operador;

    public void executeAction(int action, Token token)	throws SemanticError {

        switch(action) {
            case 1:  acao01(token); break;
            case 2:  acao02(token); break;
            case 3:  acao03(token); break;
            case 4:  acao04(token); break;
            case 5:  acao05(token); break;
            case 6:  acao06(token); break;
            case 7:  acao07(token); break;
            case 8:  acao08(token); break;
            case 9:  acao09(token); break;
            case 10: acao10(token); break;
            case 11: acao11(token); break;
            case 12: acao12(token); break;
            case 13: acao13(token); break;
            case 14: acao14(token); break;
            case 15: acao15(token); break;
            case 16: acao16(token); break;
            case 17: acao17(token); break;
            case 18: acao18(token); break;
            case 19: acao19(token); break;
            case 20: acao20(token); break;
            case 21: acao21(token); break;
            case 22: acao22(token); break;
            case 23: acao23(token); break;
            case 24: acao24(token); break;
            case 25: acao25(token); break;
            case 26: acao26(token); break;
        }

        System.out.println("Ação #"+action+", Token: "+token);
    }

    private void acao26(Token token) throws SemanticError {
        String identificador = listaIdentificadores.get(0);
        Tipo tipo = tabelaSimbolos.get(identificador);
        if(tipo == null ){
            throw new SemanticError("Erro acao 26 - 1", 0);
        }
        Tipo tipoExp = stack.pop();
        if(! tipoExp.equals(tipo)){
            throw new SemanticError("Erro acao 26 - 2", 0);
        }

        codigo.appendln("stloc " + identificador);
    }

    private void acao25(Token token) throws SemanticError {
        Tipo tipo = tabelaSimbolos.get(token.getLexeme());
        if(tipo == null){
            throw new SemanticError("Erro acao 25", 0);
        }
        stack.push(tipo);
        codigo.appendln("ldloc " + token.getLexeme());
    }

    private void acao24(Token token) throws SemanticError {
        for(String id: listaIdentificadores){
            Tipo value = tabelaSimbolos.get(id);
            if (value == null) {
                throw new SemanticError("Erro acao 24", 0);
            }

            if(value.equals(Tipo.int64)){
                tipoVar = Tipo.int64;
            }else if(value.equals(Tipo.float64)){
                tipoVar = Tipo.doublee;
            }

            codigo.appendln("call string [mscorlib]System.Console::ReadLine()");
            codigo.appendln("call " + value + "[mscorlib]System." + tipoVar + "::Parse(string)");
            codigo.appendln("stloc " + id);
        }
        listaIdentificadores.clear();
    }

    private void acao23(Token token) throws SemanticError {
        for (String id: listaIdentificadores) {
            Tipo value = tabelaSimbolos.get(id);
            if(value != null) {
                throw new SemanticError("Erro acao 23", 0);
            }

            tabelaSimbolos.put(id, tipoVar);
            codigo.appendln(" .locals (" + tipoVar + " " + id + ")");
        }
        listaIdentificadores.clear();
    }

    private void acao22(Token token) {
        listaIdentificadores.add(token.getLexeme());
    }

    private void acao21(Token token) {
        Tipo currentType = Tipo.valueOf(token.getLexeme());

        if(currentType.equals(Tipo.int64)){
            tipoVar = Tipo.int64;
        } else if(currentType.equals(Tipo.float64)) {
            tipoVar = Tipo.float64;
        }
    }

    private void acao20(Token token) {
        stack.push(Tipo.string);
        codigo.appendln(String.format("ldstr %s", token.getLexeme()));
    }
    private void acao19(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();

        if(t1.equals(Tipo.bool) && t2.equals(Tipo.bool)){
            codigo.appendln("or");
            return;
        }

        throw new SemanticError("Erro acao 18", 0);
    }

    private void acao18(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();

        if(t1.equals(Tipo.bool) && t2.equals(Tipo.bool)){
            codigo.appendln("and");
            return;
        }

        throw new SemanticError("Erro acao 18", 0);
    }

    private void acao17(Token token) {
        codigo.appendln("ldstr \"\\n\"");
        codigo.appendln("call void [mscorlib]System.Console::Write(string)");
    }
    private void acao16(Token token) {
        codigo.appendln("ret } } ");
    }

    private void acao15(Token token) {
        codigo.appendln(".assembly extern mscorlib {}\n" +
                " .assembly _codigo_objeto{}\n" +
                " .module _codigo_objeto.exe\n" +
                " .class public _UNICA{\n" +
                " .method static public void _principal() {\n" +
                " .entrypoint ");
    }

    private void acao14(Token token) {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.int64)){
            codigo.appendln("conv.i8");
        }
        codigo.appendln(String.format("call void [mscorlib]System.Console::Write(%s)", t1));
    }

    private void acao13(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.bool)){
            stack.push(Tipo.bool);
        }else{
            throw new SemanticError("Erro acao 13", 0);
        }
        codigo.appendln("ldc.i4.1");
        codigo.appendln("xor");
    }

    private void acao12(Token token) {
        stack.push(Tipo.bool);
        codigo.appendln("ldc.i4.0");
    }

    private void acao11(Token token) {
        stack.push(Tipo.bool);
        codigo.appendln("ldc.i4.1");
    }

    private void acao10(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();

        if(t1.equals(t2)){
            stack.push(Tipo.bool);
        }else{
            throw new SemanticError("Erro acao 9", 0);
        }
        switch(operador) {
            case MAIOR: codigo.appendln("cgt"); break;
            case MENOR: codigo.appendln("clt"); break;
            case IGUAL: codigo.appendln("ceq"); break;
        }
    }

    private void acao09(Token token) {
        operador = Operador.valueOf(token.getLexeme());
    }

    private void acao08(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.float64) || t1.equals(Tipo.int64)){
            stack.push(t1);
        } else {
            throw new SemanticError("Erro acao 8", 0);
        }
        codigo.appendln("ldc.18 -1");

        if (t1.equals(Tipo.int64)){
            codigo.appendln("conv.r8");
        }

        codigo.appendln("mul");
    }

    private void acao07(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.float64) || t1.equals(Tipo.int64)){
            stack.push(t1);
        } else {
            throw new SemanticError("Erro acao 7", 0);
        }
    }

    private void acao06(Token token) {
        stack.push(Tipo.float64);
        codigo.appendln("ldc.r8 ").append(token.getLexeme());
        codigo.appendln("conv.r8");
    }

    private void acao04(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();
        if (t1.equals(Tipo.float64) || t2.equals(Tipo.float64)){
            stack.push(Tipo.float64);
        } else if (t1.equals(Tipo.int64) && t2.equals(Tipo.int64)) {
            stack.push(Tipo.int64);
        }else {
            throw new SemanticError("Erro acao 4", 0);
        }
        codigo.appendln("div");
    }

    private void acao03(Token token) throws SemanticError {
        validaTipos();
        codigo.appendln("mul");
    }

    private void acao01(Token token) throws SemanticError {
        validaTipos();
        codigo.appendln("add");
    }

    private void acao02(Token token) throws SemanticError {
        validaTipos();
        codigo.appendln("sub");
    }

    private void acao05(Token token) {
        stack.push(Tipo.int64);
        codigo.appendln("ldc.i8 ").append(token.getLexeme());
        codigo.appendln("conv.r8");
    }

    private void validaTipos() throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();
        if (t1.equals(Tipo.float64) || t2.equals(Tipo.float64)){
            stack.push(Tipo.float64);
        } else if (t1.equals(Tipo.bool) || t2.equals(Tipo.string)){
            throw new SemanticError("Tipos incompativeis", 0);
        } else {
            stack.push(Tipo.int64);
        }
    }

    public String getCodigo() {
        return codigo.toString();
    }
}
