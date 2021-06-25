package janlochba.control.factory;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;

public class IssueFactory {
    public static Issue createIssue(IssueDTO issueDTO) {

        Issue issue = new Issue();

        issue.setName(issueDTO.getName());
        issue.setTyp(issueDTO.getTyp());
        issue.setDescription(issueDTO.getDescription());
        issue.setMinValue(issueDTO.getMinValue());
        issue.setMaxValue(issueDTO.getMaxValue());

        return issue;
    }
}