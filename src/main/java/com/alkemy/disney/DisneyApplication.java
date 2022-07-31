package com.alkemy.disney;

import com.alkemy.disney.models.*;
import com.alkemy.disney.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;


@SpringBootApplication
public class DisneyApplication {


	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(MainCharacterRepository mainCharacterRepository, FilmRepository filmRepository, MainCharacterFilmRepository mainCharacterFilmRepository, GenderRepository genderRepository, GenderFilmRepository genderFilmRepository, UsernameRepository usernameRepository){
		return (args) -> {

			Username username1 = new Username ("Carolina", "Gomez", "carogo@gmail.com", passwordEncoder.encode("1234"));
			usernameRepository.save(username1);

			MainCharacter character1 = new MainCharacter("https://static.wikia.nocookie.net/disney/images/7/78/IsabellaMadrigal.png/revision/latest/scale-to-width-down/291?cb=20211119173402&path-prefix=es.jpg", "Isabela Madrigal", 20, "secondary", "Is a main character in the Disney movie, Charm. Described as Miss Perfect by her younger sister, Mirabel, Isabela is the golden girl of the Madrigal family, whose gift is the power to conjure beautiful flowers and plants.");
			mainCharacterRepository.save(character1);

			MainCharacter character2 = new MainCharacter("https://www.noticiasdeentretenimientogsr.com/wp-content/uploads/2021/11/Cuando-sale-Encanto-en-Disney-Plus.gsrsgsrgsrsgss.jpg", "Mirabel Madrigal", 17, "Major", "Is a main character in the Disney movie, Charm. Described as Miss Perfect by her younger sister, Mirabel, Isabela is the golden girl of the Madrigal family, whose gift is the power to conjure beautiful flowers and plants.");
			mainCharacterRepository.save(character2);

			MainCharacter character3 = new MainCharacter("https://static.wikia.nocookie.net/disney/images/2/2e/Antonio_Madrigal.jpg/revision/latest/scale-to-width-down/350?cb=20211119180254&path-prefix=es.jpg", "Antonio Madrigal", 8, "secondary", "The youngest of the Madrigals, his gift allows him to communicate with animals.");
			mainCharacterRepository.save(character3);

			Film film1 = new Film("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/02/encanto-2628087.jpg?itok=PIUzw1as.png","Charm", LocalDate.now().plusDays(1), 5);
			filmRepository.save(film1);

			MainCharacterFilm mainCharacterFilm1 = new MainCharacterFilm(character1, character2, character3, film1);
			mainCharacterFilmRepository.save(mainCharacterFilm1);

			Gender gender1 = new Gender("Fancy", "https://static.wikia.nocookie.net/disney/images/7/78/IsabellaMadrigal.png/revision/latest/scale-to-width-down/291?cb=20211119173402&path-prefix=es.png");
			genderRepository.save(gender1);

			Gender gender2 = new Gender(" Adventure", "https://static.wikia.nocookie.net/disney/images/7/78/IsabellaMadrigal.png/revision/latest/scale-to-width-down/291?cb=20211119173402&path-prefix=es.png");
			genderRepository.save(gender2);

			Gender gender3 = new Gender("Animation", "https://static.wikia.nocookie.net/disney/images/7/78/IsabellaMadrigal.png/revision/latest/scale-to-width-down/291?cb=20211119173402&path-prefix=es.png");
			genderRepository.save(gender3);

			GenderFilm genderFilm1 = new GenderFilm(gender1, gender2, gender3, film1);
			genderFilmRepository.save(genderFilm1);

			;

			MainCharacter character4 = new MainCharacter("https://i2.wp.com/www.zarpado.com/wp-content/uploads/2019/09/Mal%C3%A9fica-Due%C3%B1a-del-Mal_P%C3%B3ster-1.jpg?w=1000.jpg", "Malificent", 30, "Major", "The dark fairy Maleficent protects the magical creatures of El Páramo. Enigmatic and criticized, yet exquisitely evil, she has come to love the princess upon whom she cast a curse of eternal sleep.");
			mainCharacterRepository.save(character4);

			MainCharacter character5 = new MainCharacter("https://i2.wp.com/www.zarpado.com/wp-content/uploads/2019/09/Mal%C3%A9fica-Due%C3%B1a-del-Mal_P%C3%B3ster-2.jpg?resize=717%2C1024.jpg", "Aurora", 16, "secondary", "Aurora, the princess who in her childhood received the curse of Maleficent, is now the Queen of El Páramo, a title that her godmother granted her. Personification of good, tenderness and compassion, the princess is destined to marry Prince Phillip.");
			mainCharacterRepository.save(character5);

			MainCharacter character6 = new MainCharacter("https://i2.wp.com/www.zarpado.com/wp-content/uploads/2019/09/CHARACTER_BANNER_PFEIFFER_LAS.jpg?resize=717%2C1024.jpg", "Ingrith", 90, "secondary", "Queen Ingrith, future mother-in-law of Aurora and Queen of Ulstead, is wicked, cunning, and selfish. A worthy adversary of the dark fairy, Maleficent, Ingrith has an evil plan to divide humans and fairies forever.");
			mainCharacterRepository.save(character6);

			Film film2 = new Film("https://www.elseptimoarte.net/carteles/341/malefica_maestra_del_mal_79919.jpg","Maleficent", LocalDate.now().plusDays(1), 5);
			filmRepository.save(film2);

			MainCharacterFilm mainCharacterFilm2 = new MainCharacterFilm(character4, character5, character6, film2);
			mainCharacterFilmRepository.save(mainCharacterFilm2);

			GenderFilm genderFilm2 = new GenderFilm(gender1, gender2, gender3, film2);
			genderFilmRepository.save(genderFilm2);



			MainCharacter character7 = new MainCharacter("https://static.wikia.nocookie.net/disney/images/8/83/FaMul%C3%A1n.png/revision/latest/top-crop/width/200/height/150?cb=20130830100817&path-prefix=es.jpg", "Fa Mulán", 18, "Major", "She is a young Chinese girl who enlists in the army in her father's place disguised as a boy to fight the Huns, as she worries about her father. Mushu, a dragon who claims to be sent by his ancestors, helps him to adapt and to do well.");
			mainCharacterRepository.save(character7);

			MainCharacter character8 = new MainCharacter("https://static.wikia.nocookie.net/disney/images/a/a0/Shang.jpg/revision/latest/top-crop/width/200/height/150?cb=20110702105814&path-prefix=es.jpg", "Li Shang", 20, "secondary", "In Mulan, he is made a Captain by his father, and is in charge of training the army to fight against Shan Yu and his army of Huns. In the army, the soldier in whom he has the most faith is Ping (but also known by his true identity, a woman named Mulán)");
			mainCharacterRepository.save(character8);

			MainCharacter character9 = new MainCharacter("https://static.wikia.nocookie.net/disney/images/1/10/Mushu.png/revision/latest/top-crop/width/200/height/150?cb=20130102170724&path-prefix=es.jpg", "Mushu", 60, "secondary", "It is a dragon that long ago messed up by taking care of Mulan's ancestors, causing one of the ancestors to have his head cut off. Since then he works playing the gong to wake up the ancestors.");
			mainCharacterRepository.save(character9);

			Film film3 = new Film("https://sm.ign.com/ign_es/screenshot/default/blob_u68k.jpg","Mulan", LocalDate.now().plusDays(2), 4);
			filmRepository.save(film3);

			MainCharacterFilm mainCharacterFilm3 = new MainCharacterFilm(character7, character8, character9, film3);
			mainCharacterFilmRepository.save(mainCharacterFilm3);

			GenderFilm genderFilm3 = new GenderFilm(gender1, gender2, gender3, film3);
			genderFilmRepository.save(genderFilm3);


		};
	}
}
