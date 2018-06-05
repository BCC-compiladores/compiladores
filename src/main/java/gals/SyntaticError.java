package gals;

public class SyntaticError extends AnalysisError
{
	public SyntaticError(String msg, int position, String word)
	 {
       super(msg, position, word);
   }
	public SyntaticError(String msg, int position)
	 {
        super(msg, position);
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }
}
