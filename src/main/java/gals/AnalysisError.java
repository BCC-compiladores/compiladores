package gals;

public class AnalysisError extends Exception
{
    private int position;
    private String word;

    public AnalysisError(String msg, int position, String word)
    {
        super(msg);
        this.position = position;
        this.word = word;
    }


    public AnalysisError(String msg, int position)
    {
        super(msg);
        this.position = position;
    }

    public AnalysisError(String msg)
    {
        super(msg);
        this.position = -1;
    }

    public int getPosition()
    {
        return position;
    }

    public String getWord() {
        return word;
    }

    public String toString()
    {
        return super.toString() + ", @ "+position;
    }
}
