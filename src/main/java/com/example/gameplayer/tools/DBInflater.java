package com.example.gameplayer.tools;

import com.example.gameplayer.model.Score;
import com.example.gameplayer.model.Users;
import com.example.gameplayer.repositories.ScoreRepository;
import com.example.gameplayer.repositories.UsersRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    private UsersRepository usersRepository;
    private ScoreRepository scoreRepository;

    public DBInflater(UsersRepository usersRepository, ScoreRepository scoreRepository) {
        this.usersRepository = usersRepository;
        this.scoreRepository = scoreRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent event){
        initData();
    }

    private void initData(){

        Users kyryl = new Users("Kyryl","Zlotnyk","Fr0zy","kzlotnyk@gmail.com","saw12345");
        Score kyrylScore = new Score(15L,kyryl);

        usersRepository.save(kyryl);
        scoreRepository.save(kyrylScore);

        Users viktor = new Users("Viktor","Yukhnevich","nineteen","vyukhnevich@gmail.com","123456789");
        Score viktorScore = new Score(0L,viktor);

        usersRepository.save(viktor);
        scoreRepository.save(viktorScore);
    }
}
