package com.coolteam.igame.controller;

import java.io.IOException;
import java.sql.SQLException;

public abstract class GameMainController {
    public abstract void stand() throws IOException, SQLException;
    public abstract void restart() throws IOException, SQLException;
    public abstract void hit() throws IOException, SQLException;
}
