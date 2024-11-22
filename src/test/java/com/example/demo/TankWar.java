package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 游戏主窗口类
public class TankWar extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // 我方坦克
    private Tank playerTank;

    // 敌方坦克列表
    private List<Tank> enemyTanks = new ArrayList<>();

    // 子弹列表
    private List<Bullet> bullets = new ArrayList<>();

    public TankWar() {
        initUI();
        initGame();
    }

    // 初始化游戏界面
    private void initUI() {
        setTitle("坦克大战");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 初始化游戏数据
    private void initGame() {
        // 创建我方坦克
        playerTank = new Tank(WIDTH / 2, HEIGHT / 2, Tank.Direction.UP, this);

        // 创建敌方坦克
        createEnemyTanks();

        // 添加键盘监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                playerTank.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerTank.keyReleased(e);
            }
        });
    }

    // 创建敌方坦克
    private void createEnemyTanks() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(WIDTH - 50);
            int y = random.nextInt(HEIGHT - 50);
            Tank enemyTank = new Tank(x, y, getRandomDirection(), this);
            enemyTanks.add(enemyTank);
        }
    }

    // 获取随机方向
    private Tank.Direction getRandomDirection() {
        Random random = new Random();
        int directionIndex = random.nextInt(4);
        return Tank.Direction.values()[directionIndex];
    }

    // 绘制游戏画面
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 绘制我方坦克
        playerTank.draw(g);

        // 绘制敌方坦克
        for (Tank enemyTank : enemyTanks) {
            enemyTank.draw(g);
        }

        // 绘制子弹
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }

    // 游戏逻辑更新
    public void update() {
        // 移动我方坦克
        playerTank.move();

        // 移动敌方坦克
        for (Tank enemyTank : enemyTanks) {
            enemyTank.move();
        }

        // 移动子弹并检测碰撞
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.move();

            // 检测子弹与敌方坦克碰撞
            for (int j = 0; j < enemyTanks.size(); j++) {
                Tank enemyTank = enemyTanks.get(j);
                if (bullet.collidesWith(enemyTank)) {
                    bullets.remove(i);
                    enemyTanks.remove(j);
                    i--;
                    j--;
                    break;
                }
            }

            // 检测子弹与我方坦克碰撞
            if (bullet.collidesWith(playerTank)) {
                bullets.remove(i);
                break;
            }
        }

        // 重新绘制画面
        repaint();
    }

    // 坦克类
    static class Tank {

        private int x;
        private int y;
        private Direction direction;
        private TankWar game;

        public Tank(int x, int y, Direction direction, TankWar game) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.game = game;
        }

        // 绘制坦克
        public void draw(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 50, 50);

            // 根据方向绘制炮管
            switch (direction) {
                case UP:
                    g.drawLine(x + 25, y, x + 25, y - 20);
                    break;
                case DOWN:
                    g.drawLine(x + 25, y + 50, x + 25, y + 70);
                    break;
                case LEFT:
                    g.drawLine(x, y + 25, x - 20, y + 25);
                    break;
                case RIGHT:
                    g.drawLine(x + 50, y + 25, x + 70, y + 25);
                    break;
            }
        }

        // 移动坦克
        public void move() {
            switch (direction) {
                case UP:
                    y -= 5;
                    if (y < 0) {
                        y = 0;
                    }
                    break;
                case DOWN:
                    y += 5;
                    if (y > game.HEIGHT - 50) {
                        y = game.HEIGHT - 50;
                    }
                    break;
                case LEFT:
                    x -= 5;
                    if (x < 0) {
                        x = 0;
                    }
                    break;
                case RIGHT:
                    x += 5;
                    if (x > game.WIDTH - 50) {
                        x = game.WIDTH - 50;
                    }
                    break;
            }
        }

        // 处理键盘按下事件
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    direction = Direction.UP;
                    break;
                case KeyEvent.VK_DOWN:
                    direction = Direction.DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                    direction = Direction.LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = Direction.RIGHT;
                    break;
                case KeyEvent.VK_SPACE:
                    Bullet bullet = new Bullet(x + 25, y + 25, direction, game);
                    game.bullets.add(bullet);
                    break;
            }
        }

        // 处理键盘释放事件
        public void keyReleased(KeyEvent e) {
            // 这里可以根据需要添加处理逻辑，比如停止坦克移动等
        }

        // 坦克方向枚举
        public enum Direction {
            UP, DOWN, LEFT, RIGHT
        }
    }

    // 子弹类
    static class Bullet {

        private int x;
        private int y;
        private Tank.Direction direction;
        private TankWar game;

        public Bullet(int x, int y, Tank.Direction direction, TankWar game) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.game = game;
        }

        // 绘制子弹
        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x, y, 10, 10);
        }

        // 移动子弹
        public void move() {
            switch (direction) {
                case UP:
                    y -= 10;
                    break;
                case DOWN:
                    y += 10;
                    break;
                case LEFT:
                    x -= 10;
                    break;
                case RIGHT:
                    x += 10;
                    break;
            }
        }

        // 检测子弹与坦克碰撞
        public boolean collidesWith(Tank tank) {
            return x >= tank.x && x <= tank.x + 50 && y >= tank.y && y <= tank.y + 50;
        }
    }

    // 游戏主循环
    public static void main(String[] args) {
        TankWar tankWar = new TankWar();
        while (true) {
            tankWar.update();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}