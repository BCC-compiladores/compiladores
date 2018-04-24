package gals;

public class LexicalError extends AnalysisError
{
    public LexicalError(String msg, int position, String word){
        super(msg,position, word);
    }
    public LexicalError(String msg, int position)
	 {
        super(msg, position);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
}
