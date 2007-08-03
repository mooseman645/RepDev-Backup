/**
 *  RepDev - RepGen IDE for Symitar
 *  Copyright (C) 2007  Jake Poznanski, Ryan Schultz, Sean Delaney
 *  http://repdev.org/ <support@repdev.org>
 *
 *  This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.repdev;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Configuration class is serialized at the start/end of the program to store things like syms open, server, and other global config things
 * @author Jake Poznanski
 *
 */
public class Config implements Serializable {
	private static Config me = new Config();
	private static final long serialVersionUID = 1L;
	
	
	private ArrayList<Integer> syms = new ArrayList<Integer>();
	private String server = "127.0.0.1";
	private int tabSize = 0; // 0 = Regular tab
	private String lastUsername = "", lastPassword = "", lastUserID;
	private boolean runOptionsAskForPrompts = true;
	private int runOptionsQueue = -1;
	private int maxQueues = 3; //The largest value this slider goes up to, We should probably scrap this since the max value is 9999 and the error checking code is good enough now that it can detect what needs to be entered. In real life, this can also be non continous large ranges, which complicates things.
    private ArrayList<SymitarFile> recentFiles = new ArrayList<SymitarFile>();
    private ArrayList<String> mountedDirs = new ArrayList<String>();
    
	private Config() {
	}

	public static void setSyms(ArrayList<Integer> syms) {
		me.syms = syms;
	}

	public static ArrayList<Integer> getSyms() {
		return me.syms;
	}

	public static Config getConfig() {
		return me;
	}

	public static String getLastPassword() {
		return me.lastPassword;
	}

	public static void setLastPassword(String lastPassword) {
		me.lastPassword = lastPassword;
	}

	public static String getLastUsername(){
		return me.lastUsername;
	}

	public static void setLastUsername(String lastUsername) {
		me.lastUsername = lastUsername;
	}

	public static void setConfig(Config config) {
		me = config;
		
		/**
		 * Note, this is where we should set any init stuff to un-null any objects
		 */
		if( me.recentFiles == null) 
			me.recentFiles = new ArrayList<SymitarFile>();
		
		if( me.mountedDirs == null) 
			me.mountedDirs = new ArrayList<String>();
	}

	public static void setServer(String server) {
		me.server = server;
	}

	public static String getServer() {
		return me.server;
	}

	public static void setTabSize(int tabSize) {
		me.tabSize = tabSize;
	}

	public static int getTabSize() {
		return me.tabSize;
	}

	public static boolean isRunOptionsAskForPrompts() {
		return me.runOptionsAskForPrompts;
	}

	public static void setRunOptionsAskForPrompts(boolean runOptionsAskForPrompts) {
		me.runOptionsAskForPrompts = runOptionsAskForPrompts;
	}

	public static int getRunOptionsQueue() {
		return me.runOptionsQueue;
	}

	public static void setRunOptionsQueue(int runOptionsQueue) {
		me.runOptionsQueue = runOptionsQueue;
	}


	public static String getLastUserID() {
		return me.lastUserID;
	}

	public static void setLastUserID(String lastUserID) {
		me.lastUserID = lastUserID;
	}
	
	public static ArrayList<SymitarFile> getRecentFiles() {
		return me.recentFiles;
	}

	public static void setRecentFiles(ArrayList<SymitarFile> recentFiles) {
		me.recentFiles = recentFiles;
	}

	public static ArrayList<String> getMountedDirs() {
		return me.mountedDirs;
	}

	public static void setMountedDirs(ArrayList<String> mountedFolders) {
		me.mountedDirs = mountedFolders;
	}

}
