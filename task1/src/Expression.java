public class Expression {
    private TypeExpr type;

    private Expression left, right;

    private String var;

    public Expression(TypeExpr oper, Expression left, Expression right) {
        this.type = oper;
        this.left = left;
        this.right = right;
    }

    public Expression(TypeExpr oper, String s, Expression left, Expression right) {
        this.type = oper;
        this.var = s;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (var == null) {
            if (type == TypeExpr.Abstr) {
                var = "(\\" + left.toString() + "." + right.toString() + ")";
            } else {
                var = "(" + left.toString() + " " + right.toString() + ")";
            }
        }
        return var;
    }

}
