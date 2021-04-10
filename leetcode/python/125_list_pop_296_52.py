def isPalindrome(s: str) -> bool:
    strs = []
    for letter in s:
        if letter.isalnum():
            strs.append(letter.lower())
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
    return True
print(isPalindrome('A man, a plan, a canal: Panama'))
print(isPalindrome('race a car'))