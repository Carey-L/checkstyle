package com.puppycrawl.tools.checkstyle.checks.custom;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * 行尾注释检测
 *
 * @author laiweisheng
 * @date 2023/9/7
 */
@StatelessCheck
public class LineEndCommentCheck extends AbstractCheck {

    public static final String MSG_KEY = "custom.line_end_annotation";

    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.SINGLE_LINE_COMMENT};
    }

    @Override
    public boolean isCommentNodesRequired() {
        return true;
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[0];
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[0];
    }

    @Override
    public void visitToken(DetailAST ast) {
        String commentText = ast.getText();

        if (!commentText.trim().endsWith("//")) {
            log(ast.getLineNo(), MSG_KEY, "Line-end comment should end with '//'");
        }
    }
}
