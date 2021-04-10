import re


def isPalindrome(s: str) -> bool:
    s = s.lower()
    s = re.sub('[^0-9a-z]', '', s)
    return s == s[::-1]


print(isPalindrome('A man, a plan, a canal: Panama'))
print(isPalindrome('race a car'))
