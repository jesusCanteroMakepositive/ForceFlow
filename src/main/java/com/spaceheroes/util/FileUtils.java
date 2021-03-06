package com.spaceheroes.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @name FileUtils
 * @description: This class contains functions to use files and folders.  
 * @author jesus.cantero
 */
public class FileUtils {
	// Pattern for create file names
	public static final String FORMAT_WITH_SLASH = "%s/%s";
	public static final String FORMAT_WITHOUT_SLASH = "%s%s";
	
	/**
	 * @name getCorrectFolderPath
	 * @description: Get the correct folder path.
	 * @param  String pPath: path of the retrieve
	 * @param  String pFolder: element type folder
	 * @return String: full path of the element folder 
	 * @author jesus.cantero
	 */
	public static String getCorrectFolderPath(String pPath, String pFolder){
		return String.format(pPath.endsWith("/") ? FORMAT_WITHOUT_SLASH : FORMAT_WITH_SLASH, pPath, pFolder);
	}
	
	/**
	 * @name listFilesForFolder
	 * @description: Get the list of files in the folder.
	 * @param  String folder: Folder to use
	 * @return List<String>: list of files in the folder 
	 * @author jesus.cantero
	 */
	public static List<String> listFilesForFolder(final File pFolder) {
		List<String> fileNameToReturn = new ArrayList<String>();
	    for (final File fileEntry : pFolder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	if(fileEntry.getName().indexOf(".") > 0){
	        		
	        		fileNameToReturn.add(fileEntry.getName());	
	        	}
	            
	        }
	    }
		return fileNameToReturn;
	}
	/**
	 * @name listFilesForFolder
	 * @description: Get the list of files in the folder with the full path
	 * @param  String pFolder: Folder to use
	 * @return List<String>: list of files in the folder 
	 * @author jesus.cantero
	 */
	public static List<String> listFilesForFolderFullPath(final File pFolder) {
		List<String> fileNameToReturn = new ArrayList<String>();
	    for (final File fileEntry : pFolder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	if(fileEntry.getName().indexOf(".") > 0){
	        		fileNameToReturn.add(fileEntry.getAbsolutePath());	
	        	}
	            
	        }
	    }
		return fileNameToReturn;
	}

	/**
	 * @name getFileNameWithoutExtension
	 * @description: Get the file name without extension
	 * @param  String pFileName: File name
	 * @return String: Filename without extension 
	 * @author jesus.cantero
	 */
	public static String getFileNameWithoutExtension(String pFileName){
		String normalizedName = pFileName;
		if (normalizedName.indexOf(".") > 0){
			normalizedName = normalizedName.split("\\.", -1)[0];
		}
		return normalizedName;
	}
	
	/**
	 * @name getNormalizedFileName
	 * @description: Get file name without version and extension
	 * @param  String pFileName: File name
	 * @return String: Filename without extension and version 
	 * @author jesus.cantero
	 */
	public static String getNormalizedFileName(String pFileName){
		String normalizedName = pFileName.toLowerCase();
		if (normalizedName.indexOf("-") > -1){
			normalizedName = normalizedName.split("-")[0];
		}
		normalizedName = getFileNameWithoutExtension(normalizedName);
		return normalizedName;
	}

}
