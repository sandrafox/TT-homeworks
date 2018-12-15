public class Parser {
    private String expression;
    private int i;
    private int length;

    public Expression parse(String s) throws ParserException {
        expression = s;
        i = 0;
        length = expression.length();
        Expression expr = parseExpr();
        skipWhitespaces();
        if (current() != '$') {
            throw new ParserException();
        }
        return expr;
    }

    private char current() {
        if (i == length) {
            return '$';
        }
        return expression.charAt(i);
    }

    private Expression parseExpr() throws ParserException {
        skipWhitespaces();
        if (current() == '\\') {
            return parseAbstr();
        }
        Expression result = parseAppl();
        skipWhitespaces();
        if (current() == '\\') {
            result = new Expression(TypeExpr.Appl, result, parseAbstr());
        }
        return result;
    }

    private Expression parseAppl() throws ParserException {
        Expression result = parseTerm();
        skipWhitespaces();
        while (current() != ')' && current() != '\\' && current() != '$') {
            result = new Expression(TypeExpr.Appl, result, parseTerm());
            skipWhitespaces();
        }
        return result;
    }

    private Expression parseTerm() throws ParserException {
        skipWhitespaces();
        Expression result;
        if (current() == '(') {
            i++;
            result = parseExpr();
            skipWhitespaces();
            if (current() != ')') {
                throw new ParserException();
            }
            i++;
            skipWhitespaces();
            return result;
        }
        if (Character.isLetter(current())) {
            String s = "";
            while (Character.isLetterOrDigit(current()) || current() == '\'') {
                s += current();
                i++;
            }
            skipWhitespaces();
            return new Expression(TypeExpr.Var, s, null, null);
        }
        throw new ParserException();
    }

    private Expression parseAbstr() throws ParserException {
        skipWhitespaces();
        if (current() != '\\') {
            throw new ParserException();
        }
        i++;
        skipWhitespaces();
        Expression result = parseTerm();
        skipWhitespaces();
        if (current() != '.') {
            throw new ParserException();
        }
        i++;
        skipWhitespaces();
        return new Expression(TypeExpr.Abstr, result, parseExpr());
    }

    private void skipWhitespaces() {
        while (Character.isWhitespace(current()) || current() == '\b') i++;
    }
}
