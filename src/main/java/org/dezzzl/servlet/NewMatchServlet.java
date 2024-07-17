package org.dezzzl.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dezzzl.dto.NewMatchDto;
import org.dezzzl.exception.ValidationException;
import org.dezzzl.model.Match;
import org.dezzzl.service.NewMatchService;
import org.dezzzl.util.JspHelper;
import org.dezzzl.validator.Error;
import org.dezzzl.validator.ValidationResult;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {

    private final NewMatchService newMatchService = NewMatchService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("newMatch"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidationResult validationResult = new ValidationResult();
        String player1 = req.getParameter("player1");
        String player2 = req.getParameter("player2");
        /// TODO: 18.07.2024 маппер

        try {
            Match match = newMatchService.startNewMatch(new NewMatchDto(player1, player2));
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }


    }

}
