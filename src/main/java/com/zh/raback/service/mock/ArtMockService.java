package com.zh.raback.service.mock;

import com.github.javafaker.Faker;
import com.zh.raback.domain.Artist;
import com.zh.raback.domain.Category;
import com.zh.raback.domain.Painting;
import com.zh.raback.domain.Product;
import com.zh.raback.repository.ArtistRepository;
import com.zh.raback.repository.CategoryRepository;
import com.zh.raback.repository.PaintingRepository;
import com.zh.raback.util.CommonUtils;
import com.zh.raback.util.FakerUtils;
import liquibase.pro.packaged.F;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
        log.debug("Start to mock artist");
        List<Artist> all = artistRepository.findAll();
        artistRepository.deleteAll(all);

        generateArtists();

    }

    private void generateArtists() {
        List<Artist> all = IntStream.range(0,900).mapToObj(customer -> {

            Artist artist = new Artist();
            artist
                .name(Faker.instance(Locale.CHINA).name().name())
                .rsName(Faker.instance(Locale.forLanguageTag("ru")).name().name())
                .enName(Faker.instance().name().name())
                .avatar(Faker.instance().avatar().image())
                .citizenship("俄罗斯")
                .sentence("俄罗斯艺术家")
                .bornAge(Faker.instance().date().birthday().toString())
                .sentence("俄罗斯艺术家")
                .brief("当前艺术家介绍")
                .artInfo("当前artInfo")
                .createDate(Instant.now())
            ;

            return artist;


            }).collect(Collectors.toList());


        artistRepository.saveAll(all);


    }


    private void generatePaintings() {
        List<Artist> artistList = artistRepository.findAll();


        List<Category> cats = categoryRepository.findAll();
        List<Painting> products = cats.stream().map(it -> {
            return IntStream.range(0, 10).mapToObj(index -> {
                int width = CommonUtils.toRandomInt(10, 40);
                int height = CommonUtils.toRandomInt(10, 40);
                String thumbnail = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                String image = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                Painting painting = new Painting();
                char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()[Faker.instance().random().nextInt(26)];
                Artist artist = artistList.get(RandomUtils.nextInt(0,artistList.size()));

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
                    .artistId(artist.getId())
                    .sentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enSentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsSentence(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .brief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enBrief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsBrief(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .info(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .enArtInfo(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .rsArtInfo(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .useArtistInfo(FakerUtils.weightedBoolean(30));




                return painting;
            }).collect(Collectors.toList());
        }).flatMap(List::stream).collect(Collectors.toList());

        paintingRepository.saveAll(products);
    }

}