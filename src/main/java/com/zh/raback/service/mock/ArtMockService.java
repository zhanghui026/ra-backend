package com.zh.raback.service.mock;

import com.github.javafaker.Faker;
import com.zh.raback.domain.Category;
import com.zh.raback.domain.Painting;
import com.zh.raback.domain.Product;
import com.zh.raback.repository.ArtistRepository;
import com.zh.raback.repository.CategoryRepository;
import com.zh.raback.repository.PaintingRepository;
import com.zh.raback.util.CommonUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ArtMockService {
    private static final Logger log = LoggerFactory.getLogger(ArtMockService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PaintingRepository paintingRepository;

    @Autowired
    private ArtistRepository artistRepository;

    /**
     * mock generate painting
     */
    public void mockPainting() {
        log.debug("Start to MockPainting");
        log.debug("Start to clear all painting");
        List<Painting> paintings = paintingRepository.findAll();
        paintingRepository.deleteAll(paintings);



        generatePaintings();
    }


    public void mockArtist() {

    }


    private void generatePaintings() {
        List<Category> cats = categoryRepository.findAll();
        List<Painting> products = cats.stream().map(it -> {
            return IntStream.range(0, 10).mapToObj(index -> {
                int width = CommonUtils.toRandomInt(10, 40);
                int height = CommonUtils.toRandomInt(10, 40);
                String thumbnail = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                String image = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                Painting painting = new Painting();
                char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()[Faker.instance().random().nextInt(26)];
                painting
                    .name(Faker.instance(Locale.CHINA).book().title())
                    .rsName(Faker.instance().book().title())
                    .enName(Faker.instance().book().title())
                    .reference(it.getName().substring(0, 2) +
                        "-" + RandomStringUtils.randomAlphabetic(5) +
                        "-" + c
                    ).width((float) width)
                    .height((float) height)
                    .age(Faker.instance().book().genre())
                    .thumbnailImg(thumbnail)
                    .rawImg(image)
                    .webImg(image)
                    .sentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enSentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsSentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .brief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enBrief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsBrief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .info(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enArtInfo(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsArtInfo(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .useArtistInfo(false);




                return painting;
            }).collect(Collectors.toList());
        }).flatMap(List::stream).collect(Collectors.toList());

        paintingRepository.saveAll(products);
    }

}
