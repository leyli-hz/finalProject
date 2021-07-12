package com.me.model.confige;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Hashtable;

public class UploaderUtils {
    private UploadBean upBean;
    public static MultipartFormDataRequest mrequest;
    private String fileName;
    private String fileSize;
    private String infilename;

    /**
     *
     * @throws java.lang.Exception
     * @param over_write_status
     * @param max_byte_size
     * @param store_address
     * @param param_name
     * @param request
     */
    public UploaderUtils(HttpServletRequest request, String param_name,
                         String store_address, long max_byte_size, boolean over_write_status)
            throws Exception {
        this.infilename = param_name;
        this.upBean = new UploadBean();
        upBean.setFolderstore(store_address);
        upBean.setFilesizelimit(max_byte_size);
        upBean.setOverwrite(over_write_status);

        if (MultipartFormDataRequest.isMultipartFormData(request)) {
            mrequest = new MultipartFormDataRequest(request);

            Hashtable files = mrequest.getFiles();

            if ((files != null) && (!files.isEmpty())) {
                UploadFile file = (UploadFile) files.get(param_name);
                this.fileName = file.getFileName();
                this.fileSize = file.getFileSize() + "";
            }
        }
    }

    /**
     *
     * @throws java.lang.Exception
     * @return boolean
     */
    public boolean save() throws Exception {
        try {
            upBean.store(mrequest, infilename);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @return String
     */
    public String getFileSize() {
        return fileSize;
    }

}
