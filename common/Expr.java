package common;

public class Expr {

	public double val;
	public int type;
	public Expr left, right;
	public Variable var;

	public Expr (double val) {
		type = EX_CONST;
		this.val = val;
		left = null;
		right = null;
		var = null;
	}

	public Expr (int type){
		this.type = type;
		left = null;
		right = null;
		val = 0;
		var = null;
	}

	public Expr (Variable var) {
		type = EX_VAR;
		left = null;
		right = null;
		val = 0;
		this.var = var;
	}

	public double eval () {
		switch (type) {
			case EX_CONST:
				return val;
			case EX_ADD:
				return left.eval() + right.eval();
			case EX_SUB:
				return left.eval() + right.eval();
			case EX_MUL:
				return left.eval() * right.eval();
			case EX_DIV:
				return left.eval() / right.eval();
			case EX_COS:
				return Math.cos(left.eval());
			case EX_SIN:
				return Math.sin(left.eval());
			case EX_TAN:
				return Math.tan(left.eval());
			case EX_VAR:
				return var.eval();
			default:
				System.err.println("Unrecognized Expr node type: " + type);
				return 0;
		}
	}
}
