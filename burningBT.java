
class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        HashMap<Node, Node> map = new HashMap<>();
        Node res = parentmapping(root, map, target);
        int max = burn(res, map);
        return max; 
    }
    public static Node parentmapping(Node root,HashMap<Node, Node> map, int target){
        Queue<Node> q = new LinkedList<>();
        Node res = null;
        q.add(root);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.data == target) res = node;
            if(node.left!=null){
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        
        return res;
    }
    
    public static int burn(Node root, HashMap<Node, Node> map){
        HashMap<Node, Integer> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        visited.put(root, 1);
        int max = 0;
        
        while(!q.isEmpty()){
            int flag =0;
            int size = q.size();
            for(int i=0; i<size;i++){
                Node temp = q.poll();
                if(temp.left!=null && visited.get(temp.left)==null){
                    flag = 1;
                    visited.put(temp.left, 1);
                    q.add(temp.left);
                }
                 if(temp.right!=null && visited.get(temp.right)==null){
                    flag = 1;
                    visited.put(temp.right, 1);
                    q.add(temp.right);
                }
                if(map.get(temp)!=null && visited.get(map.get(temp))==null){
                    flag =1;
                    visited.put(map.get(temp),1);
                    q.add(map.get(temp));
                    
                }
                
            }
            
            if(flag==1){
                max++;
            }
            
        }
        return max;
        
    }
    
    