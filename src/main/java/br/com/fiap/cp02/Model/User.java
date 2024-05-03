package br.com.fiap.cp02.Model;

public class User {
    private String name;
    private int public_repos;
    private int followers;
    private int following;


    public User(String name, int public_repos, int followers, int following) {
        this.name = name;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}

