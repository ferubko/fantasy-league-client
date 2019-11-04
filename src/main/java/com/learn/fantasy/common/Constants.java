package com.learn.fantasy.common;

/**
 * Created by stepanferubko
 */
public interface Constants {
    String FPL_LOGIN_URL = "https://users.premierleague.com/accounts/login/";

    String FPL_FULL_INFO_URL = "https://fantasy.premierleague.com/api/bootstrap-static/";

    String FPL_TEAM_INFO_URL = "https://fantasy.premierleague.com/api/entry/4854039/";//додаткова інфа про учасника ліги
    String FPL_LEAGUE_INFO_URL = "https://fantasy.premierleague.com/api/leagues-classic/802294/standings/";//учасники ліги
    //    String FPL_MEMBER_CONTENT = "https://fantasy.premierleague.com/api/my-team/%d/"; //
    String FPL_MEMBER_CONTENT = "https://fantasy.premierleague.com/api/entry/%d/"; //iнформація учасника
    //    String FPL_MEMBER_PICKS = "https://fantasy.premierleague.com/api/entry/1113809/event/11/picks/"; //гравці учасника ліги
    String FPL_MEMBER_PICKS = "https://fantasy.premierleague.com/api/entry/%d/event/%d/picks/"; //гравці учасника ліги
    String FPL_PLAYER_HISTORY = "https://fantasy.premierleague.com/api/element-summary/%d/"; //історія гравця


    String LEAGUE_STATISTIC_COMMAND = "Статистика Ліги";
    String PLAYERS_STATISTIC_COMMAND = "Статистика гравців";
    String SUCCESS = "SUCCESS";
    String FAILURE = "FAILURE";

}
