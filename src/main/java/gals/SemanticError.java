package gals;

import utils.Messages;

public class SemanticError extends AnalysisError
{
    public SemanticError(String msg, int position)
	 {
        super(msg, position);
    }
    
    public SemanticError(Messages m, int position) {
    	super(m.toString(), position);
    }

}
