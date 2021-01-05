package com.gen.com.Insurance_portal.models.RequestModels;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileModel {
    @Schema(name = "avatarImage", required = true)
    @NotNull(message = "avatarImage is required!")
    private MultipartFile avatarImage;


    @Schema(name = "bannerImage", required = true)
    @NotNull(message = "bannerImage is required!")
    private MultipartFile bannerImage;


    @Schema(name = "insuredRule", required = true)
    @NotNull(message = "insuredRule is required!")
    private MultipartFile insuredRule;
}
