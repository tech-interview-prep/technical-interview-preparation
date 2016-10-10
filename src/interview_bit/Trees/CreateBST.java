package interview_bit.trees;

import java.util.ArrayList;
import java.util.Arrays;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 */
public class CreateBST {
    public static TreeNode insertElements(ArrayList<String> s){
        int numElements = s.size();
        int numLevels = (int )(Math.log10(numElements)/Math.log10(2)) + 1;
        TreeNode root = new TreeNode(Integer.parseInt(s.get(0)));

        ArrayList<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);

        int currInd = 1;
        for(int i=1;i<numLevels;i++){

            ArrayList<TreeNode> currNodes = new ArrayList<>();
            for(int j=0;j<levelNodes.size();j++){
                TreeNode currNode = levelNodes.get(j);
                if(!s.get(currInd).equals("null")){
                    TreeNode temp = new TreeNode(Integer.parseInt(s.get(currInd)));
                    currNode.left = temp;
                    currNodes.add(temp);
                }

                currInd++;

                if(!s.get(currInd).equals("null")){
                    TreeNode temp = new TreeNode(Integer.parseInt(s.get(currInd)));
                    currNode.right = temp;
                    currNodes.add(temp);

                }

                currInd++;

            }
            levelNodes.clear();
            levelNodes = currNodes;
        }

        return root;
    }

    public static void main(String[] args){
        ArrayList<String> ip = new ArrayList<String>(Arrays.asList("1","2","3","null","null","4","null","null","5","null","null"));
        TreeNode root = CreateBST.insertElements(ip);
    }
}
