class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;   // Bug 1 fixed: last valid index

        while (left < right) {        // Bug 2 fixed: correct direction
            
            // Skip non-alphanumeric from the left
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            
            // Skip non-alphanumeric from the right
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            
            // Both pointers now sit on valid characters — compare
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;   // Bug 6 fixed: only returns false on real mismatch
            }
            
            // Match found — move both pointers inward
            left++;
            right--;
        }
        
        return true;
    }
}