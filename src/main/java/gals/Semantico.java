package gals;

import utils.Operador;
import utils.Tipo;

import java.util.ArrayDeque;

public class Semantico implements Constants
{

    ArrayDeque<Tipo> stack = new ArrayDeque<>();
    StringBuilder codigo = new StringBuilder();
    Operador operador;

    public void executeAction(int action, Token token)	throws SemanticError {

        switch(action) {
            case 1: acao1(token); break;
            case 2: acao2(token); break;
            case 3: acao3(token); break;
            case 4: acao4(token); break;
            case 5: acao5(token); break;
            case 6: acao6(token); break;
            case 7: acao7(token); break;
            case 8: acao8(token); break;
            case 9: acao9(token); break;
            case 10: acao10(token); break;
            case 11: acao11(token); break;
            case 12: acao12(token); break;
            case 13: acao13(token); break;
            case 14: acao14(token); break;
            case 15: acao15(token); break;
            case 16: acao16(token); break;
        }

        System.out.println("Ação #"+action+", Token: "+token);
    }

    private void acao16(Token token) {
        codigo.append("ret } } ");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao15(Token token) {
        codigo.append(".assembly extern mscorlib {}\n" +
                " .assembly _codigo_objeto{}\n" +
                " .module _codigo_objeto.exe\n" +
                " .class public _UNICA{\n" +
                " .method static public void _principal() {\n" +
                " .entrypoint ");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao14(Token token) {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.INT64)){
            codigo.append("conv.i8");
            codigo.append(System.getProperty("line.separator"));
        }
        codigo.append(String.format("call void [mscorlib]System.Console::Write(%s)", t1));
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao13(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.BOOL)){
            stack.push(Tipo.BOOL);
        }else{
            throw new SemanticError("Erro acao 13", 0);
        }
        codigo.append("ldc.i4.1");
        codigo.append(System.getProperty("line.separator"));
        codigo.append("xor");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao12(Token token) {
        stack.push(Tipo.BOOL);
        codigo.append("ldc.i4.0");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao11(Token token) {
        stack.push(Tipo.BOOL);
        codigo.append("ldc.i4.1");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao10(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();

        if(t1.equals(t2)){
            stack.push(Tipo.BOOL);
        }else{
            throw new SemanticError("Erro acao 9", 0);
        }
        switch(operador) {
            case MAIOR: codigo.append("cgt"); codigo.append(System.getProperty("line.separator")); break;
            case MENOR: codigo.append("clt"); codigo.append(System.getProperty("line.separator")); break;
            case IGUAL: codigo.append("ceq"); codigo.append(System.getProperty("line.separator")); break;
        }
    }

    private void acao9(Token token) {
        operador = Operador.valueOf(token.getLexeme());
    }

    private void acao8(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.FLOAT64) || t1.equals(Tipo.INT64)){
            stack.push(t1);
        } else {
            throw new SemanticError("Erro acao 8", 0);
        }
        codigo.append("ldc.18 -1");
        codigo.append(System.getProperty("line.separator"));

        if (t1.equals(Tipo.INT64)){
            codigo.append("conv.r8");
            codigo.append(System.getProperty("line.separator"));
        }

        codigo.append("mul");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao7(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.FLOAT64) || t1.equals(Tipo.INT64)){
            stack.push(t1);
        } else {
            throw new SemanticError("Erro acao 7", 0);
        }
    }

    private void acao6(Token token) {
        stack.push(Tipo.FLOAT64);
        codigo.append("ldc.r8 ").append(token.getLexeme());
        codigo.append(System.getProperty("line.separator"));
        codigo.append("conv.r8");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao4(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();
        if (t1.equals(Tipo.FLOAT64) || t2.equals(Tipo.FLOAT64)){
            stack.push(Tipo.FLOAT64);
        } else if (t1.equals(Tipo.INT64) && t2.equals(Tipo.INT64)) {
            stack.push(Tipo.INT64);
        }else {
            throw new SemanticError("Erro acao 4", 0);
        }
        codigo.append("div");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao3(Token token) throws SemanticError {
        validaTipos();
        codigo.append("mul");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao1(Token token) throws SemanticError {
        validaTipos();
        codigo.append("add");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao2(Token token) throws SemanticError {
        validaTipos();
        codigo.append("sub");
        codigo.append(System.getProperty("line.separator"));
    }

    private void acao5(Token token) {
        stack.push(Tipo.INT64);
        codigo.append("ldc.i8 ").append(token.getLexeme());
        codigo.append(System.getProperty("line.separator"));
        codigo.append("conv.r8");
        codigo.append(System.getProperty("line.separator"));
    }

    private void validaTipos() throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();
        if (t1.equals(Tipo.FLOAT64) || t2.equals(Tipo.FLOAT64)){
            stack.push(Tipo.FLOAT64);
        } else if (t1.equals(Tipo.BOOL) || t2.equals(Tipo.STR)){
            throw new SemanticError("Tipos incompativeis", 0);
        } else {
            stack.push(Tipo.INT64);
        }
    }

    public String getCodigo() {
        return codigo.toString();
    }
}
