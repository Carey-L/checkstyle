package com.puppycrawl.tools.checkstyle.checks.custom;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

/**
 * if 单行花括号 {} 检测
 *
 * @author laiweisheng
 * @date 2023/9/7
 */
@StatelessCheck
public class SingleLineIfWithBracesCheck extends AbstractCheck {

    public static final String MSG_KEY = "custom.single_line_if_check";

    @Override
    public int[] getDefaultTokens() {
        return new int[] { TokenTypes.LITERAL_IF };
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
        // 获取 if 语句的下一个节点
        DetailAST statement = ast.findFirstToken(TokenTypes.SLIST);

        // 如果 if 语句没有大括号，则报告问题
        if (statement == null) {
            log(ast.getLineNo(), MSG_KEY, "Single line if statement must have braces.");
        }
    }
}
