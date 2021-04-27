class Solution(object):
    def f(self, s, start):
        if self.TEMP.get(start)!=None:
            return self.TEMP.get(start)
        if s[start:].startswith("0"):
            self.TEMP[start] = 0
            return 0
        if len(s[start:]) == 1 or len(s[start:]) == 0:
            self.TEMP[start] = 1
            return 1
        if int(s[start:start + 2]) > 26:
            self.TEMP[start + 1] = self.f(s, start + 1)
            return self.TEMP[start + 1]
        else:
            if self.TEMP.get(start + 1)==None:
                self.TEMP[start + 1] = self.f(s, start + 1)
            if self.TEMP.get(start + 2) == None:
                self.TEMP[start + 2] = self.f(s, start + 2)
            return self.TEMP[start + 1]+self.TEMP[start + 2]
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        self.TEMP = {}
        return self.f(s, 0)
