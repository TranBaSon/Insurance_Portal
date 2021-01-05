package com.gen.com.Insurance_portal.models.RequestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileUpdateModel {
    private MultipartFile avatarImage;

    private MultipartFile bannerImage;

    private MultipartFile insuredRule;
}
