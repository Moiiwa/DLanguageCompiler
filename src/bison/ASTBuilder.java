package bison;

import lexer.Tag;
import lexer.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTBuilder {
    public List<Token> tokenList;
    public List<List> statements = new ArrayList();
    Tree tree = null;

    public ASTBuilder(List<Token> tokens){
        tokenList = tokens;
    }

    public void buildTree(){
        splitIntoStatements();
        tree = new Tree();
        addStatements();
        System.out.println(1);

    }
    private void splitIntoStatements(){
        List statement = new ArrayList();
        for (Token token: tokenList){
            if (token.getTag() != Tag.SEPARATOR){
                statement.add(token);
            }
            else{
                statement.add(token);
                statements.add(statement);
                statement = new ArrayList();
            }
        }
    }

    private void addStatements(){
        for (List statement: statements){
            Node node = parseStatement(statement);
            tree.addNode(node);
        }
    }

    private Node parseStatement(List<Token> statement){
        Token firstToken = statement.get(0);
        Node node = new Node();
        switch (firstToken.getTag()){
            case VAR:{
                boolean isWithAssignment = isDeclarationWithAssignment(statement);
                if (!isWithAssignment){
                    node = parseDeclaration(statement);
                }else{
                    node = parseDeclarationWithInitialization(statement);
                }
                return node;
            }
            case IDENTIFIER:{
                break;
            }
            case READ_INT:
            case READ_STRING:
            case READ_REAL: {
                break;
            }
            case PRINT:{
                break;
            }
            case IF:{
                break;
            }
            case FOR:{
                break;
            }
        }
        return null;
    }

    private boolean isDeclarationWithAssignment(List<Token> tokens){
        for (Token token: tokens){
            if (token.getTag() == Tag.ASSIGN)
                return true;
        }
        return false;
    }

    private Node parseDeclaration(List <Token> tokens){
        Node node = new Node();
        Node leftChild = new Node();
        List vars = new ArrayList();

        node.setValue(tokens.get(0));
        node.setTag(Tag.VAR);
        for (Token token: tokens){
            if (token.getTag() != Tag.VAR && token.getTag() != Tag.COMMA && token.getTag() != Tag.SEPARATOR){
                vars.add(token);
            }
        }
        leftChild.setValue(vars);
        leftChild.setTag(Tag.IDENTIFIER);
        leftChild.setParent(node);
        node.setLeftChild(leftChild);

        return node;
    }

    private Node parseDeclarationWithInitialization(List <Token> tokens){
        Node node = new Node();
        Node leftChild = new Node();
        Node rightChild = new Node();
        List vars = new ArrayList();
        boolean beforeAssign = true;
        List rightSideExpression = new ArrayList();

        node.setValue(tokens.get(0));
        node.setTag(Tag.VAR);

        for (Token token: tokens){
            if (token.getTag() != Tag.VAR && token.getTag() != Tag.COMMA && token.getTag() != Tag.ASSIGN && beforeAssign){
                vars.add(token);
            }else if (token.getTag() == Tag.ASSIGN){
                beforeAssign = false;
            }else if(token.getTag() != Tag.SEPARATOR){
                rightSideExpression.add(token);
            }
        }

        leftChild.setValue(vars);
        leftChild.setParent(node);
        leftChild.setTag(Tag.IDENTIFIER);
        rightChild = parseFactor(rightSideExpression);
        rightChild.setParent(node);
        node.setLeftChild(leftChild);
        node.setRightChild(rightChild);

        return node;
    }

    private Node parseFactor(List<Token> tokens){
        return null;
    }

    class Tree{
        List nodes;

        public Tree(){
            nodes = new ArrayList<Node>();
        }

        public void addNode(Node node){
            nodes.add(node);
        }

        public Iterator iterator(){
            return nodes.iterator();
        }
    }

    class Node{
        private Tag tag = null;
        private Object value = null;
        private Node leftChild = null;
        private Node rightChild = null;
        private Node parent = null;


        public Node getLeftChild() {
            return leftChild;
        }

        public Node getParent() {
            return parent;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public Object getValue() {
            return value;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setTag(Tag tag) {
            this.tag = tag;
        }

        public Tag getTag() {
            return tag;
        }
    }
}
