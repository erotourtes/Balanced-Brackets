package com.erotourtes.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public abstract class CharacterChecker {
    private static final List<Character> leftBracket = Arrays.asList('(', '[', '{', '<');
    private static final List<Character> rightBracket = Arrays.asList(')', ']', '}', '>');

    static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char el : input.toCharArray()) {
            if(leftBracket.contains(el))
                stack.add(el);
            else if (rightBracket.contains(el)) {
                if (stack.isEmpty()) return false;
                var topCharacter = stack.pop();
                if (leftBracket.indexOf(topCharacter)
                    != rightBracket.indexOf(el)) return false;
            }
        }
        return stack.isEmpty();
    }

}
