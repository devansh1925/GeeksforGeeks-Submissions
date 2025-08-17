class Solution {
    public int preference(char ch){
        if(ch=='^'){
            return 3;
        }
        else if(ch=='/' || ch=='*'){
            return 2;
        }
        else if(ch=='+' || ch=='-'){
            return 1;
        }
        return -1;
    }
    public void reverseString(StringBuilder sb){
        int n=sb.length();
        for(int i=0;i<n/2;i++){
            int frontindex=i;
            int backindex=n-i-1;
            
            char frontchar=sb.charAt(frontindex);
            char backchar=sb.charAt(backindex);
            
            sb.setCharAt(frontindex,backchar);
            sb.setCharAt(backindex,frontchar);
        }
        
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='('){
                sb.setCharAt(i,')');
            }
            else if(sb.charAt(i)==')'){
                sb.setCharAt(i,'(');
            }
        }
    }
    public String infixToPrefix(String s) {
        // code here
        StringBuilder infix = new StringBuilder(s);
        reverseString(infix);
        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder("");
        int n = infix.length();
        
        for(int i=0;i<n;i++){
            char ch = infix.charAt(i);
            
            if(ch>='a' && ch<='z'){
                prefix.append(ch);
            }
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    prefix.append(stack.pop());
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }
                
            }
            else{
                if(ch=='^'){
                    while(!stack.isEmpty() && preference(ch)<=preference(stack.peek())){
                        prefix.append(stack.pop());
                    }
                }
                else{
                    while(!stack.isEmpty() && preference(ch)<preference(stack.peek())){
                        prefix.append(stack.pop());
                    }
                }
                
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            prefix.append(stack.pop());
        }
        
        reverseString(prefix);
        
        return prefix.toString();
        
    }
}