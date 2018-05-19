package cloud.socify.dao;

import cloud.socify.entity.Channel;
import cloud.socify.entity.Source;
import cloud.socify.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubscriptionDaoImpl implements SubscriptionDao {

    @Override
    public List<Channel> getSubscription(User user) {
        Source vkSource = new Source("vk");
        List<Channel> channels = new ArrayList<>(Arrays.asList(
                new Channel("-31480508", "Пикабу", "https://vk.com/pikabu", "https://pp.userapi.com/c630017/v630017880/12715/NVVVEm5T1G0.jpg", vkSource),
                new Channel("-72495085", "/dev/null", "https://vk.com/tnull", "https://sun9-1.userapi.com/c840632/v840632737/7fa72/dxtPqm6rW9M.jpg", vkSource),
                new Channel("-48864", "Телеканал 2х2", "https://vk.com/2x2tv", "https://pp.userapi.com/c824200/v824200090/1351f0/xz8ZmU_PXPc.jpg", vkSource)
        ));
        Source instagramSource = new Source("instagram");
        channels.addAll(Arrays.asList(
                new Channel("news", "news", "https://www.instagram.com/news/", "https://scontent-bru2-1.cdninstagram.com/vp/0415af825ce522a95e64c20fa3ca9290/5B8EFEC3/t51.2885-19/s150x150/18723596_313537915736665_1919914805821440000_a.jpg", instagramSource),
                new Channel("mujjostore", "mujjostore", "https://www.instagram.com/mujjostore/", "https://scontent-bru2-1.cdninstagram.com/vp/8174446f3858f47e28c31a8f86c936b0/5B989D70/t51.2885-19/s150x150/12797594_1582277435421114_251708916_a.jpg", instagramSource),
                new Channel("fashionforall", "fashionforall", "https://www.instagram.com/fashionforall/", "https://scontent-bru2-1.cdninstagram.com/vp/a4d5f2965002e1dcf1ac2c9ba3641916/5B93D8CD/t51.2885-19/11259912_984830811537469_2021771870_a.jpg", instagramSource)
        ));

        return channels;
    }

}
