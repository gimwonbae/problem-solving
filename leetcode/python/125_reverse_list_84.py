def isPalindrome(s: str) -> bool:
    org = []
    for letter in s:
        if letter.isalnum():
            org.append(letter.lower())
    rsv = reversed(org)
    flag = True
    org_index = 0
    for rsv_letter in rsv:
        if rsv_letter != org[org_index]:
            flag = False
            break
        org_index += 1
    return flag
print(isPalindrome('A man, a plan, a canal: Panama'))
print(isPalindrome('race a car'))