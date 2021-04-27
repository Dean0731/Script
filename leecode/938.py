# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: TreeNode
        :type low: int
        :type high: int
        :rtype: int
        """
        self.low = low
        self.high = high
        self.num = 0;
        self.get(root)
        return self.num
    def get(self,root):
        num = root.val
        if num >= self.low and num <= self.high:
            self.num+=num
        if root.left != None:
            self.get(root.left)
        if root.right !=None:
            self.get(root.right)
class Solution2(object):
    def rangeSumBST(self, root, low, high):
        """
        :type root: TreeNode
        :type low: int
        :type high: int
        :rtype: int
        """
        self.num = 0
        r=[]
        while(len(r)!=0 or root !=None):
            while root != None:
                r.append(root)
                self.judge(root,low,high)
                root = root.left
            if len(r)!=0:
                root = r.pop().right
        return self.num
    def judge(self,root,low,high):
        if root.val >= low and root.val <= high:
            self.num += root.val