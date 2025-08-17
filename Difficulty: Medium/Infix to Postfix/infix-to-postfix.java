

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int priority(char ch){
        if(ch=='^'){
            return 3;
        }
        else if(ch=='*' || ch=='/'){
            return 2;
        }
        else if(ch=='+' || ch=='-'){
            return 1;
        }
        else{
            return -1;
        }
    }
    public static String infixToPostfix(String s) {
        // Your code here
        int i=0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n=s.length();
        while(i<n){
            char ch = s.charAt(i);
            
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                if(ch=='^'){
                    while(!stack.isEmpty() && priority(ch)<=priority(stack.peek())){
                        sb.append(stack.pop());
                    }
                }
                else{
                    while(!stack.isEmpty() && priority(ch)<=priority(stack.peek())){
                        sb.append(stack.pop());
                    }
                }
                
                stack.push(ch);
            }
            i++;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}