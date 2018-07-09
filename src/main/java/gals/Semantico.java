package gals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.TextStringBuilder;

import org.apache.commons.text.matcher.StringMatcher;
import utils.Constante;
import utils.Messages;
import utils.Operador;
import utils.Tipo;

public class Semantico implements Constants
{

    ArrayDeque<Tipo> stack = new ArrayDeque<>();
    ArrayDeque<Token> pilhaDesvios = new ArrayDeque<>();
    TextStringBuilder codigo = new TextStringBuilder();
    ArrayList<String> listaIdentificadores = new ArrayList<>();
    ArrayList<String> listaRotulos = new ArrayList<>();
    HashMap<String, Tipo> tabelaSimbolos = new HashMap<>();
    ArrayList<Constante> constants = new ArrayList<>();
    Tipo tipoVar = null;
    Operador operador;

    public void executeAction(int action, Token token)	throws SemanticError {
        System.out.println("Ação #"+action+", Token: "+token);

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
            case 27: acao27(token); break;
            case 28: acao28(token); break;
            case 29: acao29(token); break;
            case 30: acao30(token); break;
            case 31: acao31(token); break;
            case 32: acao32(token); break;

        }

    }
    private void acao32(Token token) throws SemanticError {
        for (String id: listaIdentificadores) {
            Tipo t = identificaTipoLexema(token.getLexeme());
            Constante c = new Constante(t, id, getLastAddress()+1, token.getLexeme());
            Tipo value = tabelaSimbolos.get("c_"+id);
            if(value != null) {
                throw new SemanticError("Erro acao 32", 0);
            }

            tabelaSimbolos.put("c_"+id, t);
            //first we gotta define the address for the constant
            codigo.appendln(" .locals init (["+c.getAddress()+"] " + c.getTipo() + " " + id + ")");
            //then stack the value of the constant
            if (c.getTipo().equals(Tipo.bool)) { //if bool string is different
                String command = getMethodByType(c.getTipo());
                if(token.getLexeme().trim().equals("true")) {
                    command = command+"1";
                }
                else {
                    command = command+"0";
                }
                codigo.appendln(command);

            }else {
                codigo.appendln(getMethodByType(c.getTipo())+" "+token.getLexeme());
            }
            //save value into local
            codigo.appendln("stloc."+c.getAddress());
            //add constant to constant list
            constants.add(c);
        }
        listaIdentificadores.clear();
    }
    private void acao31(Token token) {
        codigo.appendln("//codigo gerado pela acao 31");
        //get last loop
        Token lastLoop = pilhaDesvios.pop();
        String newLabel = getNewLabelName(true);
        if (lastLoop.getLexeme().equals("whileTrue")) {
            codigo.appendln("br "+lastLoop.getLabel());
            codigo.appendln(newLabel+":");
        }
        else {
            codigo.appendln("brfalse "+lastLoop.getLabel());
            codigo.appendln(newLabel+":");
        }
        codigo.appendln("//fim");
        String cod = codigo.toString();
        cod = cod.replace("#:"+lastLoop.getLabel()+":#", newLabel);
        codigo.clear();
        codigo.append(cod);
    }
    private void acao30(Token token) {
        String label1 = getLastLabel();
        String label2 = getNewLabelName(true);
        codigo.appendln("//codigo gerado pela acao 30");
        codigo.appendln("br "+label2);
        codigo.appendln(label1+":");
        codigo.appendln("//fim");
    }
    private void acao29(Token token) {
        codigo.appendln("//codigo gerado pela acao 29");
        codigo.appendln(getLastLabel()+":");
        codigo.appendln("//fim");
    }
    private void acao28(Token token) {
        codigo.appendln("//codigo gerado pela acao 28");
        if (token.getLexeme().equals("ifTrue") || token.getLexeme().equals("whileTrue")) {
            token.setLabel(this.getLastLabel());
            if (token.getLexeme().equals("whileTrue")) {
                pilhaDesvios.add(token);
                codigo.appendln("brfalse #:"+token.getLabel()+":#");
            }
            else {
                codigo.appendln("brfalse "+getNewLabelName(true));
            }
        }
        else {
            token.setLabel(this.getLastLabel());
            if (token.getLexeme().equals("whileFalse")) {
                pilhaDesvios.add(token);
                codigo.appendln("br #:"+token.getLabel()+":#");
            }
            else {
                codigo.appendln("br "+getNewLabelName(true));
            }


        }
        codigo.appendln("//fim");
    }
    private void acao27(Token token) {
        codigo.appendln("//codigo gerado pela acao 27");
        codigo.appendln(getNewLabelName(true)+":");
        codigo.appendln("//fim");
    }
    private void acao26(Token token) throws SemanticError {
        String identificador = listaIdentificadores.get(0);
        Tipo tipo = tabelaSimbolos.get("v_"+identificador) == null ?  tabelaSimbolos.get("c_"+identificador) : tabelaSimbolos.get("v_"+identificador);
        if(tipo == null ){
            throw new SemanticError(Messages.IDENTIFICADOR_NAO_DECLARADO, token.getPosition());
        }
        Tipo tipoExp = stack.pop();
        if(! tipoExp.equals(tipo)){
            throw new SemanticError(Messages.TIPO_INCOMPATIVEL_ATRIBUICAO, token.getPosition());
        }
        if (tipo.equals(Tipo.int64)){
            codigo.appendln("conv.i8");
        }
        codigo.appendln("stloc " + identificador);
    }

    private void acao25(Token token) throws SemanticError {
        Tipo tipo = tabelaSimbolos.get("v_"+token.getLexeme()) == null ?  tabelaSimbolos.get("c_"+token.getLexeme()) : tabelaSimbolos.get("v_"+token.getLexeme());
        if(tipo == null){
            throw new SemanticError(Messages.IDENTIFICADOR_NAO_DECLARADO, token.getPosition());
        }
        stack.push(tipo);
        codigo.appendln("ldloc " + token.getLexeme());
        if (tipo.equals(Tipo.int64)) {
            codigo.appendln("conv.r8");
        }
    }

    private void acao24(Token token) throws SemanticError {
        for(String id: listaIdentificadores){
            Tipo value = tabelaSimbolos.get("v_"+id);
            if (value == null) {
                throw new SemanticError(Messages.IDENTIFICADOR_NAO_DECLARADO, token.getPosition());
            }

             if(value.equals(Tipo.float64)){
                tipoVar = Tipo.doublee;
            }

            codigo.appendln("call string [mscorlib]System.Console::ReadLine()");
            codigo.appendln("call " + value + "[mscorlib]System." + StringUtils.capitalize(tipoVar.toString()) + "::Parse(string)");
            codigo.appendln("stloc " + id);
        }
        listaIdentificadores.clear();
    }

    private void acao23(Token token) throws SemanticError {
        for (String id: listaIdentificadores) {
            Tipo value = tabelaSimbolos.get("v_"+id);
            if(value != null) {
                throw new SemanticError(Messages.IDENTIFICADOR_JA_DECLARADO, token.getPosition());
            }

            tabelaSimbolos.put("v_"+id, tipoVar);
            codigo.appendln(" .locals (" + tipoVar + " " + id + ")");
        }
        listaIdentificadores.clear();
    }

    private void acao22(Token token) {
        listaIdentificadores.add(token.getLexeme());
    }

    private void acao21(Token token) {
        String lexeme = token.getLexeme();
        if (lexeme.contains("int") || lexeme.contains("float")) {
            lexeme = lexeme+"64";
        }
        Tipo currentType = Tipo.valueOf(lexeme);

        if(currentType.equals(Tipo.int64)){
            tipoVar = Tipo.getEnum("int64");
        } else if(currentType.equals(Tipo.float64)) {
            tipoVar = Tipo.getEnum("float64");
        }else if (currentType.equals(Tipo.string)) {
            tipoVar = Tipo.getEnum("string");
        }else if (currentType.equals(Tipo.bool)) {
            tipoVar = Tipo.getEnum("bool");
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

        throw new SemanticError(Messages.OPERACAO_LOGICA_BINARIA, token.getPosition());
    }

    private void acao18(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();

        if(t1.equals(Tipo.bool) && t2.equals(Tipo.bool)){
            codigo.appendln("and");
            return;
        }

        throw new SemanticError(Messages.OPERACAO_LOGICA_BINARIA, token.getPosition());
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
            throw new SemanticError(Messages.OPERACAO_LOGICA_UNARIA, token.getPosition());
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
        // Question here, does the type need to be the same, can't we compare ints to floats?
        //if(t1.equals(t2)){
        //    stack.push(Tip0o.bool);
        //adicionar string, bool
        if (
            (t1.equals(Tipo.int64) || t1.equals(Tipo.float64)) &&
            (t2.equals(Tipo.float64) || t2.equals(Tipo.int64)) ||
            (t1.equals(Tipo.string) && t2.equals(Tipo.string))
            ) {
            stack.push(Tipo.bool);
        }else{
            throw new SemanticError(Messages.OPERACAO_RELACIONAL, token.getPosition());
        }
        switch(operador) {
            case MAIOR: codigo.appendln("cgt"); break;
            case MENOR: codigo.appendln("clt"); break;
            case IGUAL: codigo.appendln("ceq"); break;
            case MAIOR_IGUAL: {
                codigo.appendln("clt");
                codigo.appendln("ldc.i4.0");
                codigo.appendln("ceq");
                break;
            }
            case MENOR_IGUAL: {
                codigo.appendln("cgt");
                codigo.appendln("ldc.i4.0");
                codigo.appendln("ceq");
                break;
            }
            case DIFERENTE:{
                codigo.appendln("ceq");
                codigo.appendln("ldc.i4.0");
                codigo.appendln("ceq");
                break;
            }
        }
    }

    private void acao09(Token token) {
        operador = Operador.getEnum(token.getLexeme());
    }

    private void acao08(Token token) throws SemanticError {
        Tipo t1 = stack.pop();
        if(t1.equals(Tipo.float64) || t1.equals(Tipo.int64)){
            stack.push(t1);
        } else {
            throw new SemanticError(Messages.OPERACAO_ARITMETICA_UNARIA, token.getPosition());
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
            throw new SemanticError(Messages.OPERACAO_ARITMETICA_UNARIA, token.getPosition());
        }
    }

    private void acao06(Token token) {
        stack.push(Tipo.float64);
        codigo.appendln("ldc.r8 "+token.getLexeme().replace(',', '.'));
        codigo.appendln("conv.r8");
    }

    private void acao05(Token token) {
        stack.push(Tipo.int64);
        codigo.appendln("ldc.i8 "+token.getLexeme());
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
            throw new SemanticError(Messages.OPERACAO_ARITMETICA_BINARIA, token.getPosition());
        }
        codigo.appendln("div");
    }

    private void acao03(Token token) throws SemanticError {
        validaTipos(token);
        codigo.appendln("mul");
    }


    private void acao02(Token token) throws SemanticError {
        validaTipos(token);
        codigo.appendln("sub");
    }

    private void acao01(Token token) throws SemanticError {
        validaTipos(token);
        codigo.appendln("add");
    }

    private void validaTipos(Token t) throws SemanticError {
        Tipo t1 = stack.pop();
        Tipo t2 = stack.pop();
        if (t1.equals(Tipo.float64) || t2.equals(Tipo.float64)){
            stack.push(Tipo.float64);
        } else if (t1.equals(Tipo.bool) || t2.equals(Tipo.string)){
            throw new SemanticError(Messages.OPERACAO_ARITMETICA_UNARIA, t.getPosition());
        } else {
            stack.push(Tipo.int64);
        }
    }

    public String getCodigo() {
        return codigo.toString();
    }

    private String getNewLabelName(boolean addToList) {
        int labelQty = listaRotulos.size();

        String str = "label"+(labelQty+1);
        if (addToList)
            listaRotulos.add(str);

        return str;
    }

    private String getLastLabel() {
        return listaRotulos.get(listaRotulos.size()-1);
    }

    private int getLastAddress() {
        if (constants.size() == 0) {
            return -1;
        }
        return constants.get(constants.size()-1).getAddress();
    }
    public String getMethodByType(Tipo tipo) {
        switch (tipo) {
            case int64:
                return "ldc.i8";
            case float64:
                return "ldc.r8";
            case string:
                return "ldstr";
            case bool:
                return "ldc.i4.";
            default:
                return "";
        }
    }

    private Tipo identificaTipoLexema(String lexema) {
        if (lexema.trim().charAt(0) == '"') {
            return Tipo.string;
        }
        else if (lexema.trim().equals("true") || lexema.trim().equals("false")) {
            return Tipo.bool;
        }
        else {
            try {
                Integer.parseInt(lexema);
                return Tipo.int64;
            }
            catch(NumberFormatException e) {
                try {
                    Double.parseDouble(lexema);
                    return Tipo.float64;
                }
                catch(NumberFormatException err) {

                }
            }
        }
        return null;
    }

    private Constante findConstById(String id) {
        for (Constante c : constants) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
